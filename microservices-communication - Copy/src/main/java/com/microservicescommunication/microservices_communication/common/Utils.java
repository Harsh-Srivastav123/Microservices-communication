package com.microservicescommunication.microservices_communication.common;

import org.springframework.aop.target.LazyInitTargetSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static final List<String> methodList= Arrays.asList("rest","grpc","kafka","rabbitmq","aws-sns","aws-sqs","redis");
}
