FROM nginx

COPY default.conf /etc/nginx/nginx.conf
COPY dist/ /www/data/


# Expose ports
EXPOSE 80

RUN  apt-get update \
     && apt-get install -y --no-install-recommends python3 \
     && rm -r /var/cache/apt/* \
     && chmod -R 777 /var/log/nginx /var/cache/nginx /var/run \
     && chgrp -R 0 /etc/nginx \
     && chmod -R g+rwX /etc/nginx \
