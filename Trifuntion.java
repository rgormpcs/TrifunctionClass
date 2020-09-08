import java.time.LocalDate;
import java.time.Period;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Trifuntion {
    public static void main(String[] args) {

        Function<Integer,String> addCero= x-> x<10 ? "0"+x :String.valueOf(x);
        BiFunction<Integer,String,String> addName= (age, name)->name.concat(" Is:").concat(String.valueOf(age));

        PersonalInterface<Integer,Integer,Integer, LocalDate> parseDarte=
                (day,month,year)->
                        LocalDate.parse(year+"-"+addCero.apply(month)+"-"+addCero.apply(day));

        PersonalInterface<Integer,Integer,Integer, Integer> calculateAgeOf=
                (day,month,year)->
                        Period.between(parseDarte.apply(day,month,year), LocalDate.now()).getYears();

        System.out.println(addName.apply(calculateAgeOf.apply(16,01,1989),"Ricardo"));
    }
    @FunctionalInterface
    interface PersonalInterface<T,U,V,X>{
        X apply(T t,U u, V v );
    }
}
