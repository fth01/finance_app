FROM maven:3.8.1-openjdk-17-slim
USER root

ENV CHROME_DRIVER_VERSION="131.0.6778.264"

RUN apt -f install -y
RUN apt-get update -y \
&& apt-get install -y wget unzip
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb

RUN echo 'Using chrome driver version: $CHROME_DRIVER_VERSION'
RUN wget --no-verbose -0 /tmp/chromedriver-linux64.zip https://storage.googleapis.com/chrome-for-testing-public/$CHROME_DRIVER_VERSION/linux64/chromedriver-linux64.zip
RUN rm -rf /opt/selenium/chromedriver
RUN unzip /tmp/chromedriver-linux64.zip -d /opt/selenium
RUN rm /tmp/chromedriver-linux64.zip
RUN mv /opt/selenium/chromedriver-linux64/chromedriver /opt/selenium/chromedriver-$CHROME_DRIVER_VERSION
RUN chmod 755 /opt/selenium/chromedrive-$CHROME_DRIVER_VERSION
RUN ln -fs /opt/selenium/chromedrive-$CHROME_DRIVER_VERSION /usr/bin/chromedriver

WORKDIR /finance-app
COPY . /finance-app/

RUN ls -l /finance-app

RUN mvn clean verify -D"cucumber.filter.tags=@smoke"; exit 0