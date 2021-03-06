package com.drajer.cda.parser;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class CdaParserConstants {

  private static final CdaParserConstants constants = new CdaParserConstants();

  public static XPath CCDAXPATH;
  public static XPathExpression DOC_ID_EXP;

  public static final String DEFAULT_XPATH = "/ClinicalDocument";

  // RR data
  public static final String RR_DOC_CODE = "88085-6";
  public static final String RR_DOC_CODE_SYSTEM = "http://loinc.org";
  public static final String RR_DOC_DISPLAY_NAME =
      "Reportability response report Document Public health";
  public static final String RR_DOC_CONTENT_TYPE = "application/xml;charset=utf-8";

  private CdaParserConstants() {
    initialize();
  }

  public static CdaParserConstants getInstance() {
    return constants;
  }

  private void initialize() {

    CCDAXPATH = XPathFactory.newInstance().newXPath();

    try {

      DOC_ID_EXP = CdaParserConstants.CCDAXPATH.compile("/ClinicalDocument/id[not(@nullFlavor)]");

    } catch (XPathExpressionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  NamespaceContext ctx =
      new NamespaceContext() {
        public String getNamespaceURI(String prefix) {
          if (prefix.contentEquals("hl7")) {
            return "urn:hl7-org:v3";
          } else if (prefix.contentEquals("hl7:sdtc")) {
            return "urn:hl7-org:v3:sdtc";
          } else return null;
        }

        public Iterator getPrefixes(String val) {
          return null;
        }

        public String getPrefix(String uri) {
          return null;
        }
      };
}
