package org.generation.hackathon2.Agenda;
import org.generation.hackathon2.Contact.Contact;
import javax.swing.plaf.PanelUI;
import java.util.*;

import static org.generation.hackathon2.Style.Style.*;

public class Agenda {
    private List<Contact> agenda = new ArrayList<>();
    private final int maxContact = 10;

    public Agenda() {

    }

    public List<Contact> getAgenda() {
        return agenda;
    }

    public int getMaxContact() {
        return maxContact;
    }

    //1. Añadir contacto - Margarita
    public void addContact(Contact c) {
        if (fullAgenda()) {
            System.out.println("La agenda está llena. No se pueden añadir mas contactos.");
        } else if (existContact(c)) {
            System.out.println("El contacto ya existe.");
        } else {
            agenda.add(c);
            System.out.println("Contacto añadido exitosamente.");
        }
    }

    //2. Verifica si existe Contacto - Santiago
    public boolean existContact(Contact c) {
        if (c == null) {
            return false;
        }
        for (int i = 0; i < agenda.size(); i++) {
            Contact contactoActual = agenda.get(i);

            if (contactoActual.getNombre().equalsIgnoreCase(c.getNombre()) &&
                    contactoActual.getApellido().equalsIgnoreCase(c.getApellido())) {
                return true;
            }
        }
        return false;

    }

    //3. Listar contactos - Elías
    public void listContact() {
//        Muestra todos los contactos de la agenda en el siguiente formato: Nombre Apellido - Teléfono.
//        Ordena los contactos alfabéticamente por nombre y apellido antes de mostrarlos.

        // Ordena la lista completa por el Nombre
        agenda.sort(Comparator.comparing(Contact::getNombre));

        for (Contact contacto : agenda) {
            System.out.println(contacto.getFullName() + " - " + contacto.getTelefono());

        }


    }

    //4. Buscar contacto - Elías
    public String searchContact(String name, String lastName) {

        for (Contact contacto : agenda) {
            if (contacto.getNombre().equals(name) && contacto.getApellido().equals(lastName)) {
                return "Telefono: " + contacto.getTelefono();
            }

        }
        return "Usuario no Encontrador";
    }

    //5. Eliminar contacto - Jesús
    public void removeContact(Contact c) {
        for (int i = 0; i < agenda.size(); i++) {
            Contact contacto = agenda.get(i);
            if (contacto.getNombre().equals(c.getNombre())
                    && contacto.getApellido().equals(c.getApellido())) {
                agenda.remove(i);
                System.out.println("Se eliminó registro con éxito.");
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }
    //


    //6. Modificar telefono - Andrea
    public void updateTel(String nombre, String apellido, String nuevoTelefono) {
        for (int i = 0; i < agenda.size(); i++) {
            Contact contacto = agenda.get(i);
            if (contacto.getNombre().equals(nombre) && contacto.getApellido().equals(apellido)) {
                contacto.setTelefono(nuevoTelefono);
                System.out.println("El numero de telefono se ha modificado correctamente.");
                return;
            }
        }
        System.out.println("No se ha encontrado el contacto ingresado.");
    }

    //7. Agenda llena - Andrea
    public boolean fullAgenda() {
        if (agenda.size() >= maxContact) {
            return true;
        } else {
            return false;
        }
    }


    public String freeSpace() {
        int availablesSpaces = maxContact - agenda.size();

        if (availablesSpaces == 0) {
            return ("La agenda está llena. No hay espacios disponibles.");
        } else {
            return ("Espacios disponibles: " + availablesSpaces);
        }
    }

    public void continuar() {
        Scanner scanner = new Scanner(System.in);
        String enter;
        System.out.print(PURPLE + "\nPresiona ENTER para continuar..." + RESET);
        enter = scanner.nextLine();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String apellido;
        String telefono;
        String enter;
        boolean salir = false;
        int opcion;

        System.out.println(BLUE + BOLD);
        System.out.println("  █████╗  ██████╗ ███████╗███╗   ██╗██████╗  █████╗ ");
        System.out.println(" ██╔══██╗██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔══██╗");
        System.out.println(" ███████║██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████║");
        System.out.println(" ██╔══██║██║   ██║██╔══╝  ██║╚██╗██║██║  ██║██╔══██║");
        System.out.println(" ██║  ██║╚██████╔╝███████╗██║ ╚████║██████╔╝██║  ██║");
        System.out.println(" ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝");
        System.out.println(RESET);
        System.out.print(YELLOW + "Pulsa Enter para entrar al Menú..." + RESET);
        enter = scanner.nextLine();


        while (!salir) {
            limpiarPantalla();
            // Encabezado estilizado
            System.out.println(CYAN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
            System.out.println(CYAN + BOLD + "║            AGENDA DE CONTACTOS               ║" + RESET);
            System.out.println(CYAN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);
            System.out.println(BLUE + "1. " + RESET + "Añadir Contacto");
            System.out.println(BLUE + "2. " + RESET + "Verificar Contacto");
            System.out.println(BLUE + "3. " + RESET + "Listar Contactos");
            System.out.println(BLUE + "4. " + RESET + "Buscar Contacto");
            System.out.println(BLUE + "5. " + RESET + "Eliminar Contacto");
            System.out.println(BLUE + "6. " + RESET + "Modificar Telefono de un Contacto");
            System.out.println(BLUE + "7. " + RESET + "Revisar Espacio Disponible");
            System.out.println(RED + "8. SALIR" + RESET);
            System.out.print(BOLD + "Selecciona una opción " + CYAN + "" + RESET);
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1; // Le asignamos un valor que no exista en tus opciones del switch
            }

            switch (opcion) {
                case 1:
                    System.out.println(GREEN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + BOLD + "║              AÑADIR CONTACTO                 ║" + RESET);
                    System.out.println(GREEN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);

                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido del contacto: ");
                    apellido = scanner.nextLine();
                    System.out.print("Telefono del contacto: ");
                    telefono = scanner.nextLine();

                    addContact(new Contact(nombre, apellido, telefono));
                    continuar();
                    break;
                case 2:
                    System.out.println(GREEN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + BOLD + "║            VERIFICAR CONTACTO                ║" + RESET);
                    System.out.println(GREEN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);

                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido del contacto: ");
                    apellido = scanner.nextLine();

                    Contact contact1 = new Contact(nombre, apellido, searchContact(nombre, apellido));

                    if (existContact(contact1)) {
                        System.out.println(YELLOW + contact1.getFullName() + " existe en la agenda" + RESET);
                    } else {
                        System.out.println(YELLOW + contact1.getFullName() + " no esta en la agenda" + RESET);
                    }
                    continuar();
                    break;
                case 3:
                    System.out.println(GREEN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + BOLD + "║            LISTA DE CONTACTOS                ║" + RESET);
                    System.out.println(GREEN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);
                    listContact();
                    System.out.print(PURPLE + "\nPresiona ENTER para continuar..." + RESET);
                    enter = scanner.nextLine();

                    break;
                case 4:
                    System.out.println(GREEN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + BOLD + "║              BUSCAR CONTACTOS                ║" + RESET);
                    System.out.println(GREEN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);

                    System.out.println("Buscar Contactos");
                    System.out.print("Nombre del Contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido del Contacto: ");
                    apellido = scanner.nextLine();

                    System.out.println(searchContact(nombre, apellido));
                    continuar();
                    break;
                case 5:
                    System.out.println(GREEN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + BOLD + "║            ELIMINAR CONTACTOS                ║" + RESET);
                    System.out.println(GREEN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);

                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido del contacto: ");
                    apellido = scanner.nextLine();


                    removeContact(new Contact(nombre, apellido, searchContact(nombre, apellido)));

                    System.out.print(PURPLE + "\nPresiona ENTER para continuar..." + RESET);
                    enter = scanner.nextLine();
                    break;
                case 6:
                    System.out.println(GREEN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + BOLD + "║             MODIFICAR TELEFONO               ║" + RESET);
                    System.out.println(GREEN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);
                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido del contacto: ");
                    apellido = scanner.nextLine();
                    System.out.print("Escribe el nuevo número telefonico: ");
                    telefono = scanner.nextLine();
                    updateTel(nombre,apellido,telefono);
                    continuar();
                    break;
                case 7:
                    System.out.println(GREEN + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + BOLD + "║          " + freeSpace().toUpperCase() + "             ║" + RESET);
                    System.out.println(GREEN + BOLD + "╚══════════════════════════════════════════════╝" + RESET);
                    freeSpace();
                    continuar();
                    break;
                case 8:
                    System.out.println(RED + BOLD + "╔══════════════════════════════════════════════╗" + RESET);
                    System.out.println(RED + BOLD + "║             SALIENDO DE LA AGENDA            ║" + RESET);
                    System.out.println(RED + BOLD + "╚══════════════════════════════════════════════╝" + RESET);
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no dispobible");
                    break;
            }
        }
    }
}