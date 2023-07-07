package Monads;

import org.junit.Assert;
import org.junit.Test;

public class MonadTest {

    @Test
    public void whenNotUsingMonad_shouldBeOk() {
        NotMonadSample test = new NotMonadSample();
        Assert.assertEquals(6.0, test.apply(2), 0.000);
    }

    @Test
    public void whenUsingMonad_shouldBeOk() {
        MonadSample test = new MonadSample();
        Assert.assertEquals(6.0, test.apply(2), 0.000);
    }
}

