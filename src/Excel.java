import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Excel {
    public static void main(String[] args) {
    }
        private static List<ArrayList> excelTable = new ArrayList<>();

        public static void addUsers(String firstName, String lastName, String age) {
            ArrayList<String> newUsers = new ArrayList<>();
            newUsers.add(firstName);
            newUsers.add(lastName);
            newUsers.add(age);
            excelTable.add(newUsers);
        }

        public static void initial(String inFile) throws FileNotFoundException {
            excelTable = FileUtils.read(inFile);
        }

        public static List<ArrayList> get() {
            return excelTable;
        }
    }



