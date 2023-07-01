package testdata.jsondatareader;

public class KazpostUser {
    public String iin,
            kazpostCitizenship,
            kazpostDateOfBirth,
            city,
            address,
            sourceOfIncome,
            defaultIdNum;

    public FullName fullName;

    public static class FullName {

        public String firstName;
        public String lastName;
        public String patronymic;
    }
}
