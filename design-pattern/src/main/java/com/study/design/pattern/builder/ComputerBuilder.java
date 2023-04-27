package com.study.design.pattern.builder;


public class ComputerBuilder {

    private final Computer computer;

    private ComputerBuilder() {
        this.computer = new Computer();
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder setRam(String ram) {
        computer.setRam(ram);
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    public ComputerBuilder setMainBoard(String mainBoard) {
        computer.setMainBoard(mainBoard);
        return this;
    }

    public ComputerBuilder setGraphicCard(String graphicCard) {
        computer.setGraphicCard(graphicCard);
        return this;
    }

    public Computer build() {
        return this.computer;
    }

}
