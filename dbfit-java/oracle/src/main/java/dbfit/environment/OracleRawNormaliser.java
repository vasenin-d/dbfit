package dbfit.environment;

import dbfit.util.TypeNormaliserFactory;
import fit.TypeAdapter;
import java.sql.SQLException;
import dbfit.util.TypeTransformer;

public class OracleRawNormaliser implements TypeNormaliser {

    static {
        TypeNormaliserFactory.setNormaliser(byte[].class, new OracleRawNormaliser());
    }

    @Override
    public Object normalise(Object value) throws Exception {
        if (value instanceof byte[]) {
            return value;
        }
        if (value instanceof String) {
            return TypeAdapter.hexStringToByteArray((String) value);
        }
        return null;
    }
}
