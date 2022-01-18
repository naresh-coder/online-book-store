# Book Order Project



[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

book-online-store is spring boot application 

## Features

- register user/customer , upate customer
- add book, update book , get book informaiton
- create order , update order, see montly order stastitics
here swagger link http://localhost:8080/swagger-ui.html


## Tech

book-online-store is spring boot application is used the following technologies

- [SpringBoot] 
- [lombok] 
- [spring-security] 
- [h2Db] -
- [swagger-api] 
- [Junit5] 
- [mockito] 


## Installation

book-onine-store requires maven to run.

Install the dependencies and devDependencies and start the server.

```sh
 mvn install
java jar -jar online-book-store-0.0.1-SNAPSHOT.jar
```



## Plugins

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.



## Docker

book-online-store is very easy to install and deploy in a Docker container.

By default, the Docker will expose port 8080, so change this within the
Dockerfile if necessary. When ready, simply use the Dockerfile to
build the image.

```sh
cd book-online-store
docker build -t <youruser>/book-online-sttore:${package.json.version} .
```

This will create the book-online-store image and pull in the necessary dependencies.
Be sure to swap out `${package.json.version}` with the actual
version of Dillinger.

Once done, run the Docker image and map the port to whatever you wish on
your host. In this example, we simply map port 8080 of the host to
port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8080:8080 --restart=always --cap-add=SYS_ADMIN --name= book-online-store <youruser>/ book-online-store:${package.json.version}
