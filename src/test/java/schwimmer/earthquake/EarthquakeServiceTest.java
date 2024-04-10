package schwimmer.earthquake;

import org.junit.jupiter.api.Test;
import schwimmer.earthquake.json.FeatureCollection;
import schwimmer.earthquake.json.Properties;

import static org.junit.jupiter.api.Assertions.*;

class EarthquakeServiceTest {

    @Test
    void oneHour() {
        // given
        EarthquakeService service = new EarthquakeServiceFactory().getService();

        // when
        FeatureCollection collection = service.oneHour().blockingGet();

        // then
        Properties properties = collection.features[0].properties;
        assertNotNull(properties.place);
        assertNotEquals(0, properties.mag);
        assertNotEquals(0, properties.time);
    }
}