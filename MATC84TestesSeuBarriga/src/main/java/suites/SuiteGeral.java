package suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import tests.ContaTest;
import tests.MovimentacaoTest;
import tests.ResumoTest;
import tests.SaldoTest;

@Suite
@SelectClasses({
    ContaTest.class,
    MovimentacaoTest.class,
    ResumoTest.class,
    SaldoTest.class
})
public class SuiteGeral {
}
