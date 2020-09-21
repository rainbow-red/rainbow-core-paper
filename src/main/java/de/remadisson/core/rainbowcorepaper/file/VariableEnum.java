package de.remadisson.core.rainbowcorepaper.file;

public enum VariableEnum {

    LuckPermsPrefix(true), AutoDeop(true), JoinAndLeave(false);

    private Object value;

    VariableEnum(Object value){
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
