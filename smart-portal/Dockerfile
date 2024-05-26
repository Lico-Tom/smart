FROM baseimage:v1.1

RUN mkdir -p /opt/smart-portal/conf &&  \
    mkdir -p /opt/smart-portal/dist && \
    mkdir -p /opt/smart-portal/script

# 指定工作路径
WORKDIR /opt/smart-portal
ENV HOME_DIR /opt/smart-portal

COPY dist /opt/smart-portal/dist
COPY script /opt/smart-portal/script
COPY conf /opt/smart-portal/conf

CMD ["/opt/smart-portal/script/start.sh", "run"]
