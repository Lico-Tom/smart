#!/bin/bash

if [ -n "$VUE_APP_BASE_URL" ]; then
    # 根据mysql pod的名字获取mysql的ip地址并写入环境变量
      VUE_APP_BASE_URL="http://$(nslookup "$VUE_APP_BASE_URL" | awk '/^Address: / {print $2}'):9091"
      sed -i "s#target_url#${VUE_APP_BASE_URL}#g" "${HOME_DIR}"/conf/nginx.conf
fi

if [ -n "$VUE_APP_BASE_HOST" ]; then
    sed -i "s#target_url#${VUE_APP_BASE_HOST}#g" "${HOME_DIR}"/conf/nginx.conf
fi

cp "${HOME_DIR}"/conf/nginx.conf /usr/local/nginx/conf/
/usr/local/nginx/sbin/nginx
tail -f /dev/null
