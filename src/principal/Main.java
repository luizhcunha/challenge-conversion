package principal;

import models.InterfaceUser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        InterfaceUser interfaceUsuario = new InterfaceUser();
        interfaceUsuario.menu();
    }
}