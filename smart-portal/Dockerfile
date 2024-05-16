FROM nginx

# 创建目录
RUN mkdir -p /home/nginx/vue
RUN apt update
RUN apt install net-tools

# 指定工作路径
WORKDIR /home/nginx/vue

COPY ./conf/default.conf /etc/nginx/conf.d/
COPY ./dist /home/nginx/vue
