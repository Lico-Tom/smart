package com.smart.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.core.utils.ApplicationContextUtil;
import com.smart.core.utils.JwtTokenUtil;
import com.smart.security.UpdatePasswordStatus;
import com.smart.security.domain.Resource;
import com.smart.security.domain.UserDetailsImpl;
import com.smart.security.domain.UpdatePasswordParam;
import com.smart.security.domain.User;
import com.smart.security.domain.UserParam;
import com.smart.security.service.ResourceService;
import com.smart.security.service.UserCacheService;
import com.smart.security.service.UserService;
import com.smart.security.mapper.UserMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhonghao
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2023-12-03 16:13:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    private final JwtTokenUtil jwtTokenUtil;

    private final PasswordEncoder passwordEncoder;

    private final ResourceService resourceService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper,
                           PasswordEncoder passwordEncoder,
                           JwtTokenUtil jwtTokenUtil,
                           ResourceService resourceService) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.resourceService = resourceService;
    }

    @Override
    public User register(UserParam userParam) {
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        user.setStatus(1);
        String pwd = passwordEncoder.encode(userParam.getPassword());
        user.setPassword(pwd);
        userMapper.insert(user);
        return userMapper.selectByUsername(user.getUsername());
    }

    @Override
    public String login(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new UsernameNotFoundException("密码不正确.");
        }
        if (!userDetails.isEnabled()) {
            throw new UsernameNotFoundException("帐号已被禁用.");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(userDetails);
        insertLoginLog(username);
        return token;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    @Override
    public User getAdminByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public List<User> list(String keyword, int pageSize, int pageNum) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", keyword);
        Page<User> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        return list(page, queryWrapper);
    }

    @Override
    public IPage<User> list(int currentPage, int pageSize, User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(user.getId() != null, "id", user.getId());
        queryWrapper.eq(Strings.isNotBlank(user.getUsername()), "username", user.getUsername());
        queryWrapper.eq(Strings.isNotBlank(user.getEmail()), "email", user.getEmail());
        queryWrapper.eq(Strings.isNotEmpty(user.getNickName()), "nick_name", user.getNickName());
        queryWrapper.eq(Strings.isNotEmpty(user.getNote()), "note", user.getNote());
        queryWrapper.eq(user.getStatus() != -1, "status", user.getStatus());
        IPage<User> page = new Page<>(currentPage, pageSize, count(queryWrapper));
        queryWrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return userMapper.selectPage(page, queryWrapper);
    }

    @Override
    public int updatePassword(UpdatePasswordParam updatePasswordParam) {

        User byUsername = userMapper.selectByUsername(updatePasswordParam.getUsername());
        if (byUsername != null) {
            return UpdatePasswordStatus.NOT_USER.getCode();
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", updatePasswordParam.getUsername())
                .eq("password", updatePasswordParam.getOldPassword());
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return UpdatePasswordStatus.NOT_PASSWORD.getCode();
        }
        user.setPassword(updatePasswordParam.getNewPassword());
        saveOrUpdate(user);
        return UpdatePasswordStatus.SUCCESS.getCode();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Resource> resourceList = resourceService.getResourceList(user.getId());
        return new UserDetailsImpl(user, resourceList);
    }

    @Override
    public UserCacheService getCacheService() {
        return ApplicationContextUtil.getApplicationContext().getBean(UserCacheService.class);
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
/*        UmsAdmin admin = getAdminByUsername(username);
        if(admin==null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        loginLogMapper.insert(loginLog);*/
    }
}




