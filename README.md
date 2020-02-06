# Very simple HTTP request in Kotlin using Spring framework and OkHttp client

[Accompanying blog post](https://codingrabbithole.com/kotlin-get-api-data-using-okhttp/)

Step:
* Set up project (eg using [spring initializer](https://start.spring.io/))
* Import OkHttp library (see build.gradle.kts file)
* Create a class for our HTTP call
* Build a request - pass in a url and any other info you may need (eg http headers)
* Send the request by initialising OkHttpClient and executing the HTTP call
* Parse the response
