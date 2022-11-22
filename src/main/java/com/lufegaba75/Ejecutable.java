package com.lufegaba75;

import com.lufegaba75.modelo.Usuario;
import com.lufegaba75.repositorio.UsuarioRepositorioImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutable {
    public static void main(String[] args) {

        UsuarioRepositorioImpl repositorio = new UsuarioRepositorioImpl();


        boolean estado = true;

        do{
            int opcion;
            try {
                Scanner sc = new Scanner(System.in);
                sc.useDelimiter("\n");
                System.out.println("Introduzca una de las siguientes opciones: \n"
                        + "1. para actualizar un usuario. \n"
                        + "2. para eliminar un usuario. \n"
                        + "3. para agregar un usuario. \n"
                        + "4. para listar los usuarios. \n"
                        + "5. para salir");
                opcion = sc.nextInt();

                switch (opcion){
                    case 1:
                        Usuario u = new Usuario();
                        System.out.println("Seleccione la id del usuario que desea actualizar: \n"
                                + repositorio.listar().toString());
                        u.setId(sc.nextLong());
                        System.out.println("Introduzca el nuevo nombre de usuario: \n");
                        u.setUsername(sc.next());
                        System.out.println("Introduzca el nuevo password de usuario: \n");
                        u.setPassword(sc.next());
                        System.out.println("Introduzca el nuevo email: \n");
                        u.setEmail(sc.next());
                        repositorio.actualizar(u);
                        System.out.println(repositorio.listar().toString());
                        break;
                    case 2:
                        Usuario u2 = new Usuario();
                        System.out.println("Seleccione la id del usuario que desea eliminar: \n"
                                + repositorio.listar().toString());
                        u2.setId(sc.nextLong());
                        repositorio.eliminar(u2.getId());













                        System.out.println(repositorio.listar().toString());
                        break;
                    case 3:
                        Usuario u3 = new Usuario();
                        System.out.println("Introduzca nuevo nombre de usuario: \n");
                        u3.setUsername(sc.next());
                        System.out.println("Introduzca nueva contraseña: \n");
                        u3.setPassword(sc.next());
                        System.out.println("Introduzca nuevo email: \n");
                        u3.setEmail(sc.next());
                        repositorio.guardar(u3);
                        System.out.println(repositorio.listar().toString());
                        break;
                    case 4:
                        System.out.println(repositorio.listar().toString());
                        break;
                    case 5:
                        estado = false;
                        System.out.println("Ha decidido finalizar el programa.");
                        break;
                    case 0:
                        System.out.println("Debe introducir un número del 1 al 5");
                        break;
                    default:
                        System.out.println("Debe introducir un número del 1 al 5");
                        break;
                }
            } catch (InputMismatchException e) {}
        }while (estado);

    }
}
//roducto producto = new Producto();
//            producto.setId(5L);
//            producto.setNombre("Teclado Corsair k95 mecánico");
//            producto.setPrecio(700L);
//            Categoria categoria = new Categoria();
//            categoria.setId(2L);
//            producto.setCategoria(categoria);
//            repositorio.guardar(producto);
//            System.out.println("Producto modificado con éxito");
//            repositorio.listar().forEach(System.out::println);