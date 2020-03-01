package com.thoughtworks.ddd.sample.zn.charity.application.common.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BaseCommand {
    private String operator;
    private LocalDateTime triggerTime;
}
