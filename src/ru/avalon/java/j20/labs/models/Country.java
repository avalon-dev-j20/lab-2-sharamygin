package ru.avalon.java.j20.labs.models;

import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Модель представления о стране.
 */
public class Country {
    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */
    @Override
    public int hashCode(){
        return code.hashCode() + name.hashCode();
    }
    
    @Override
    public boolean equals(Object object){
        if (object == this)
            return true;
        if (object.getClass() != getClass())
            return false;

        Country other = (Country)object;
        return code.equals(other.code) && name.equals(other.name);
    }

    /**
     * Возвращает экземпляр страны созданный из переданного
     * текста в формате 'Код:Название'.
     *
     * @param text тектс в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка
     * имеет неверный формат.
     */
    
    public static Country valueOf(String text) throws IOException, ParseException {
        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */

        Pattern pattern = Pattern.compile("([A-Z]{2}):([а-яА-Я\\s]*)");
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) throw new ParseException("Not allowed match", 0);
        return new Country(matcher.group(1), matcher.group(2));

    }
}
