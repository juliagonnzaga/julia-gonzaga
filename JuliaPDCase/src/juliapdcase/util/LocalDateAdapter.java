package juliapdcase.util;
/**
 *
 * @author Júlia Gonzaga
 */
import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public String marshal(LocalDate bt) throws Exception {
        return bt.toString();
    }

    @Override
    public LocalDate unmarshal(String vt) throws Exception {
        return LocalDate.parse(vt);
    }
    
}
