package stepdefinitions;

import com.propio.pruebas.modelo.Persona;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

public class CucumberConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(Persona.class, new TableEntryTransformer<Persona>() {
            @Override
            public Persona transform(Map<String, String> entry) {
                return new Persona(entry.get("nombre"),entry.get("apellidos"),entry.get("ciudad"));
            }
        }));
    }
}
