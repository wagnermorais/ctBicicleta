package br.desafio.ctbicicleta.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(       		
                description = "Contexto",
                version = "1.0.0",
                title = "Desafio",
                contact = @Contact(
                   name = "x", 
                   email = "x@.com.br" 
                )
        ),	      
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
    	externalDocs = @ExternalDocs(value = "Desafio", url = "http://www.desafio.br")
)
public interface ApiDocumentationConfig {

}