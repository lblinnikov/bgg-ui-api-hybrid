package helpers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.ValidatableResponse;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.junit.Test;
//import org.openqa.selenium.remote.Response;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import static io.restassured.RestAssured.given;

public class ApiHelper {



    public void checkResponse() {
        RestAssured.baseURI = "http://www.boardgamegeek.com/xmlapi/boardgame/";
        given().
                get().
                then().
                assertThat().
                statusCode(200).and().contentType(ContentType.XML);
    }

    /**
     *
     * @param gameId id of the game
     * @return text value of the maximum poll result
     */

    public static String getMaximumDependencyLevelText(int gameId) {
        // TODO 1. grab maximum dependency level text from XML response, given gameId

        RestAssured.baseURI = "http://www.boardgamegeek.com/xmlapi/boardgame";

        given().
                get(gameId).
                then().
                assertThat().statusCode(250);



        return "String";

    }
}