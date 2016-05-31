package algorithms.hashing;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import algorithms.hashing.HashMap;
import algorithms.hashing.LinearHashing;
import algorithms.hashing.Map;

public class HashTest {
	private Hashable<String> hashable;

	@BeforeMethod
	public void setup() {
		this.hashable = new LinearHashing();
	}

	@Test
	public void hash() {
		Assert.assertEquals(hashable.hash("foo"), hashable.hash("foo"));
		Assert.assertNotEquals(hashable.hash("foo"), hashable.hash("bar"));
		// Verify that this does not result in an overflow
		Assert.assertNotEquals(hashable.hash("aPrettyLongStringAPrettyLongStringAPrettyLongStringAPrettyLongStringAPrettyLongString"), Integer.MAX_VALUE);
	}

	@Test
	public void testDistribution() {
		Map<String, AtomicInteger> map = new HashMap<>();

		for (int i = 0; i < 10 * 1000; i++) {
			String key = UUID.randomUUID().toString();

			if (!map.containsKey(key)) {
				map.put(key, new AtomicInteger(0));
			}

			map.get(key).incrementAndGet();
		}

		Assert.assertTrue(map.values().size() <= Hashable.TABLE_SIZE);

		for (AtomicInteger value : map.values()) {
			Assert.assertTrue(value.get() > 10);
		}
	}
}
