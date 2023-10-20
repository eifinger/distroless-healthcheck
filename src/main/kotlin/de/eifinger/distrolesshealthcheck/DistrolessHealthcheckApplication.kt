package de.eifinger.distrolesshealthcheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.system.exitProcess

@SpringBootApplication
class DistrolessHealthcheckApplication

fun main(args: Array<String>) {
	args.forEach {
		if (it == "--healthcheck") {
			val client: HttpClient = HttpClient.newBuilder()
				.build();
			val request: HttpRequest = HttpRequest.newBuilder()
				.uri(URI("http://localhost:8080/actuator/health"))
				.GET()
				.build()
			val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() != 200) {
				exitProcess(1)
			}
			exitProcess(0)
		}
	}
	runApplication<DistrolessHealthcheckApplication>(*args)
}
