abstract class EducationalInstitution {

    private String name;
    private String address;
    private int students;

    public EducationalInstitution(String name, String address, int students) {
        this.name = name;
        this.address = address;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public abstract String getType();

    public abstract String getAdmissionRequirements();

    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Адрес: " + address);
        System.out.println("Студентов: " + students);
        System.out.println("Тип: " + getType());
    }
}

class School extends EducationalInstitution {

    private int grades;

    public School(String name, String address, int students, int grades) {
        super(name, address, students);
        this.grades = grades;
    }

    @Override
    public String getType() {
        return "Школа";
    }

    @Override
    public String getAdmissionRequirements() {
        return "Требуется справка о прививках";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Классы: " + grades);
    }
}

class University extends EducationalInstitution {

    private int faculties;

    public University(String name, String address, int students, int faculties) {
        super(name, address, students);
        this.faculties = faculties;
    }

    @Override
    public String getType() {
        return "Университет";
    }

    @Override
    public String getAdmissionRequirements() {
        return "Требуются результаты ЕГЭ";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Факультеты: " + faculties);
    }
}

public class Lab9 {

    public static void main(String[] args) {

        EducationalInstitution[] institutions = {
                new School("Гимназия № 1", "ул. Ленина, 10", 750, 11),
                new School("Средняя школа № 17", "пр. Мира, 4", 620, 9),
                new School("Гимназия № 5", "ул. Гагарина, 23", 890, 11),
                new University("БГУ", "пр. Независимости, 4", 12000, 8),
                new University("БГУИТ", "ул. Октябрьская, 23", 5400, 5)
        };

        System.out.println("Информация об учреждениях:");
        for (EducationalInstitution inst : institutions) {
            inst.displayInfo();
            System.out.println();
        }

        System.out.println("Требования к поступлению:");
        for (EducationalInstitution inst : institutions) {
            System.out.println(inst.getName() + " (" + inst.getType() + "): "
                    + inst.getAdmissionRequirements());
        }

        System.out.println("\nПроверка инстанцирования:");
        System.out.println("Объект абстрактного класса EducationalInstitution создать нельзя (ошибка компиляции).");
    }
}

