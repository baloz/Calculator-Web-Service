package com.tw.calculator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
@ConfigurationProperties("calculatorapi")
public class CalculatorConfiguration {

    private boolean add;
    private boolean multiply;
    private boolean divide;

    private boolean enablefeature;
    private boolean disablefeature;

    public boolean isEnablefeature() {
        return enablefeature;
    }

    public void setEnablefeature(boolean enablefeature) {
        this.enablefeature = enablefeature;
    }

    public boolean isDisablefeature() {
        return disablefeature;
    }

    public void setDisablefeature(boolean disablefeature) {
        this.disablefeature = disablefeature;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isMultiply() {
        return multiply;
    }

    public void setMultiply(boolean multiply) {
        this.multiply = multiply;
    }

    public boolean isDivide() {
        return divide;
    }

    public void setDivide(boolean divide) {
        this.divide = divide;
    }
}
