FROM zenika/alpine-maven

ADD . /root
WORKDIR /root
RUN chmod +x *.sh && /root/build.sh
EXPOSE 8080

CMD /root/run.sh