package economics.dependencies;

import economics.MockitoTestCase;
import economics.model.Observations;

public class XmlToGdpUnmarshallerTest extends MockitoTestCase {
    private final static String messageFromFed = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><observations realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" observation_start=\"1776-07-04\" observation_end=\"9999-12-31\" units=\"lin\" output_type=\"1\" file_type=\"xml\" order_by=\"observation_date\" sort_order=\"asc\" count=\"80\" offset=\"0\" limit=\"100000\">  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1929-01-01\" value=\"985.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1930-01-01\" value=\"900.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1931-01-01\" value=\"841.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1932-01-01\" value=\"731.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1933-01-01\" value=\"720.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1934-01-01\" value=\"798.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1935-01-01\" value=\"869.7\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1936-01-01\" value=\"981.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1937-01-01\" value=\"1033.3\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1938-01-01\" value=\"998.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1939-01-01\" value=\"1078.7\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1940-01-01\" value=\"1171.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1941-01-01\" value=\"1372.7\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1942-01-01\" value=\"1624.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1943-01-01\" value=\"1889.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1944-01-01\" value=\"2041.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1945-01-01\" value=\"2018.3\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1946-01-01\" value=\"1799.7\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1947-01-01\" value=\"1786.3\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1948-01-01\" value=\"1866.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1949-01-01\" value=\"1855.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1950-01-01\" value=\"2018.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1951-01-01\" value=\"2176.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1952-01-01\" value=\"2259.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1953-01-01\" value=\"2362.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1954-01-01\" value=\"2348.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1955-01-01\" value=\"2517.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1956-01-01\" value=\"2569.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1957-01-01\" value=\"2621.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1958-01-01\" value=\"2595.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1959-01-01\" value=\"2780.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1960-01-01\" value=\"2850.6\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1961-01-01\" value=\"2918.6\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1962-01-01\" value=\"3096.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1963-01-01\" value=\"3232.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1964-01-01\" value=\"3420.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1965-01-01\" value=\"3639.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1966-01-01\" value=\"3873.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1967-01-01\" value=\"3971.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1968-01-01\" value=\"4164.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1969-01-01\" value=\"4291.6\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1970-01-01\" value=\"4299.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1971-01-01\" value=\"4446.0\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1972-01-01\" value=\"4682.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1973-01-01\" value=\"4964.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1974-01-01\" value=\"4944.0\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1975-01-01\" value=\"4921.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1976-01-01\" value=\"5191.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1977-01-01\" value=\"5433.7\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1978-01-01\" value=\"5733.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1979-01-01\" value=\"5930.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1980-01-01\" value=\"5913.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1981-01-01\" value=\"6052.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1982-01-01\" value=\"5939.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1983-01-01\" value=\"6202.3\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1984-01-01\" value=\"6639.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1985-01-01\" value=\"6893.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1986-01-01\" value=\"7116.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1987-01-01\" value=\"7342.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1988-01-01\" value=\"7650.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1989-01-01\" value=\"7924.0\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1990-01-01\" value=\"8081.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1991-01-01\" value=\"8055.6\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1992-01-01\" value=\"8326.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1993-01-01\" value=\"8563.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1994-01-01\" value=\"8900.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1995-01-01\" value=\"9129.4\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1996-01-01\" value=\"9471.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1997-01-01\" value=\"9881.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1998-01-01\" value=\"10304.0\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1999-01-01\" value=\"10812.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2000-01-01\" value=\"11268.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2001-01-01\" value=\"11404.6\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2002-01-01\" value=\"11606.9\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2003-01-01\" value=\"11914.2\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2004-01-01\" value=\"12358.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2005-01-01\" value=\"12735.5\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2006-01-01\" value=\"13046.1\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2007-01-01\" value=\"13362.8\"/>  <observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"2008-01-01\" value=\"13442.6\"/></observations>";

    public void testConvertXmlToObject() {
        XmlToGdpUnmarshaller unmarshallerXmlTo = new XmlToGdpUnmarshaller();
        Observations observations = unmarshallerXmlTo.convertGdpFromXmlToObject(messageFromFed);
        assertNotNull(observations);
        assertCollectionSizeGreaterThan(1, observations.getObservation());
        System.out.println(observations);
    }
}