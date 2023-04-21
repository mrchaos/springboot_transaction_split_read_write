package cherry.cworld.awsproxyrds;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import cherry.cworld.awsproxyrds.common.Utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class AwsproxyrdsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void objToString() {
		HashMap<String, Object> hMap = new HashMap<>();
		HashMap<String, Object> hMap2 = new HashMap<>();
		hMap.put("p1", "v1");
		hMap.put("p2", "v2");
		hMap2.put("c1", "v1");
		hMap2.put("c2", "v2");
		hMap.put("h", hMap2);

		log.info(Utils.jsonToString(hMap));
	}
}
