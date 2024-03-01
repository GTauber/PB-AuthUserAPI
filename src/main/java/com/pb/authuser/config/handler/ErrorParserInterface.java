package com.pb.authuser.config.handler;

import com.pb.authuser.models.entity.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.reactivestreams.Publisher;

@FunctionalInterface
public interface ErrorParserInterface {

    Publisher<Void> parse(Response<?> error) throws JsonProcessingException;

}
