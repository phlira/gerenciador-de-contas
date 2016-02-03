package br.com.gerenciador.servidor;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		HttpServer server = startaServidor();
		System.out.println("Servidor Rodando");
		System.in.read();
		server.shutdownNow();
	}
	
	static HttpServer startaServidor() {
		URI uri = URI.create("http://localhost:8080");
		ResourceConfig config = new ResourceConfig().packages("br.com.gerenciador");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}
	

}
