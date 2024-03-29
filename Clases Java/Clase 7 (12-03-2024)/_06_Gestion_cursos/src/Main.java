import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner objScan = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;

        do {
            System.out.println("""
                    MENU DE OPCIONES
                    1. Administrar cursos.
                    2. Administrar estudiantes.
                    3. Salir.
                    """);
            option = objScan.nextInt();

            switch (option) {
                case 1:
                    int option2 = 0;
                    do {
                        System.out.println("""
                                MENU DE CURSOS
                                1. Crear un curso.
                                2. Buscar curso por código.
                                3. Listar cursos.
                                4. Salir.
                                """);
                        option2 = objScan.nextInt();
                        switch (option2) {
                            case 1:
                                objGestion.guardarCurso(objScan);
                                break;

                            case 2:
                                System.out.println("Ingresa el código del curso. ");
                                String codigo = objScan.next();
                                System.out.println(objGestion.buscarPorCodigo(codigo).toString());
                                break;

                            case 3:
                                objGestion.listarCursos();
                                break;


                        }
                    } while (option2 != 4);
                    break;

                case 2:
                    int option3 = 0;
                    do {
                        System.out.println("""
                                Menu gestión de estudiantes
                                1. Agregar estudiante.
                                2. Eliminar estudiante.
                                3. Listar estudiantes.
                                4. Salir
                                """);
                        option3 = objScan.nextInt();

                        switch (option3) {
                            case 1:
                                objGestion.listarCursos();

                                System.out.println("Ingrese el código del curso donde desea inscribir el estudiante.");
                                String codigo = objScan.next();
                                Curso curso = objGestion.buscarPorCodigo(codigo);

                                if (curso == null) {
                                    System.out.println("Curso no encontrado");
                                } else {
                                    curso.guardarEstudiante(objScan);
                                }
                                break;
                            case 2: //Caso para eliminar un estudiante
                                //1. Listar todos los cursos
                                objGestion.listarCursos();
                                //2.Preguntar al usuario cual es el curso del estudiante a eliminar
                                System.out.println("Ingrese el codigo del curso del estudiante a eliminar: ");
                                codigo = objScan.next();
                                //3.LLamar al metodo que elimina
                                Curso objcurso = objGestion.buscarPorCodigo(codigo);
                                if (objcurso == null){
                                    System.out.println("Codigo no valido");
                                }else {
                                    //eliminar
                                    objcurso.eliminarEstudiante(objScan);
                                }
                            break;
                            case 3:
                                objGestion.listarCursos();

                                System.out.println("Ingrese el código del curso donde desea inscribir el estudiante.");
                                codigo = objScan.next();
                                curso = objGestion.buscarPorCodigo(codigo);

                                if (curso == null) {
                                    System.out.println("Curso no encontrado");
                                } else {
                                    curso.listarEstudiantes();
                                }
                                break;
                        }
                    } while (option3 != 4);
                    break;
            }
        } while (option != 3);
    }
}