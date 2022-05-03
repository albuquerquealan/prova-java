package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.entity.Ser;
import br.com.confidencecambio.javabasico.exception.IncorrectNameException;
import org.springframework.stereotype.Component;

@Component
public class NameService {

    public static final String PODE_SER_VAZIO_OU_NULO = "Name não pode ser vazio ou nulo";

    public String getFirstName(Ser ser) throws IncorrectNameException {
        if(emptyOrBlankStringValidation(ser)) {
            throw new IncorrectNameException(PODE_SER_VAZIO_OU_NULO);
        }

        ser.setName(removeEmptySpaces(ser));

        String[] split = ser.getName().split(" ");
        return split[0];
    }


    public String getLastName(Ser ser) throws IncorrectNameException {
        if(emptyOrBlankStringValidation(ser)) {
            throw new IncorrectNameException(PODE_SER_VAZIO_OU_NULO);
        }

        ser.setName(removeEmptySpaces(ser));

        String[] split = ser.getName().split(" ");

        if (split.length > 1) {
            StringBuilder lastName = new StringBuilder();

            for (int i=1; i<split.length; i++ ) {
                lastName.append(split[i] + " ");
            }

            return lastName.toString().trim();
        }

        return ser.getName();
    }

    public String getUpperCaseName(Ser ser) throws IncorrectNameException {
        if(emptyOrBlankStringValidation(ser)) {
            throw new IncorrectNameException(PODE_SER_VAZIO_OU_NULO);
        }

        ser.setName(removeEmptySpaces(ser));

        return ser.getName().toUpperCase();
    }

    public String getShortName(Ser ser) throws IncorrectNameException {
        if(emptyOrBlankStringValidation(ser)) {
            throw new IncorrectNameException(PODE_SER_VAZIO_OU_NULO);
        }

        ser.setName(removeEmptySpaces(ser));

        String[] split = ser.getName().split(" ");

        if (split.length > 1) {

            StringBuilder shortName = new StringBuilder();

            for (int i=1; i < split.length - 1; i++ ) {
                shortName.append(split[i].charAt(0) + ". ");
            }

            return split[0] + " " + shortName.toString().trim() + " " + split[split.length - 1];
        }

        return ser.getName();
    }


    private boolean emptyOrBlankStringValidation(Ser ser) {
        return ser.getName() == null ||
                ser.getName().isBlank() ||
                ser.getName().isEmpty();
    }

    private String removeEmptySpaces(Ser ser) {
        return ser.getName().trim();
    }


}
