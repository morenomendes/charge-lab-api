FROM httpd:2.4

### Install OS tools
RUN apt-get update && apt-get install --yes curl git &&  apt-get install --yes gnupg2

### Installl Node
RUN curl -sL https://deb.nodesource.com/setup_10.x | bash
RUN apt-get install --yes nodejs