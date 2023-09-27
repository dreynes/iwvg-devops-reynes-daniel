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

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .filter(user -> familyName.equals(user.getFamilyName()))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(1, 1),
                        (accumulator, fraction) -> {
                            accumulator = accumulator.multiply(fraction);
                            return accumulator;
                        }
                );
    }

    public static Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction :: isNegative))
                .map(User::getFamilyName);
    }

}
