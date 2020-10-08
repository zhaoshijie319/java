package net.netty.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Command implements Serializable {

    private static final long serialVersionUID = 1320123451767766661L;

    private String actionName;
}