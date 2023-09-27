package es.upm.miw.iwvg_devops.code;

import java.util.Collection;
import java.util.stream.Stream;
public class Search {

    public Double findFirstDecimalFractionByUserName(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .findFirst().get()
                .decimal();
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .map(User::getFractions)
                .flatMap(Collection::stream)
                .filter(fraction -> fraction.getDenominator() != 0)
                .reduce(Fraction::higher)
                .get();
    }

}