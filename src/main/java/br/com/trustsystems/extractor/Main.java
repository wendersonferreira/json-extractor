package br.com.trustsystems.extractor;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import net.minidev.json.JSONArray;

public class Main {
    public static void main(String[] args) {
        String[] keysToExtract = new String[]{"UserId", "Name", "ContactEmail", "ContactName", "ContactPhone"};
        String json = "{\"status\":{\"@code\":\"200\"},\"messages\":[],\"timestamp\":\"1561760722296\",\"content\":[{\"link\":{\"@rel\":\"self\",\"@href\":\"https://welc-uat.callidusondemand.com/PM/REST/entity/usrset/pk/14937512303370000\"},\"userno\":{\"@label\":\"UserNo\",\"#text\":\"14937512303370000\"},\"userid\":{\"@label\":\"UserId\",\"#text\":\"DHARDIN\"},\"prosta\":{\"@label\":\"ProSta\",\"@display\":\"Active\",\"#text\":\"1\"},\"name\":{\"@label\":\"Name\",\"#text\":\"Derhon Hardin\"},\"contactname\":{\"@label\":\"ContactName\",\"#text\":\"Derhon Hardin\"},\"contactphone\":{\"@label\":\"ContactPhone\",\"@display\":\"(813) 206-2139\",\"#text\":\"8132062139\"},\"contactemail\":{\"@label\":\"ContactEmail\",\"#text\":\"Derhon.Hardin@wellcare.com\"},\"chgpswd\":{\"@label\":\"ChgPswd\",\"@display\":\"No\",\"#text\":\"0\"},\"cloudgrid\":{\"@label\":\"CloudGrid\",\"@display\":\"Yes\",\"#text\":\"1\"},\"invalidloginattempts\":{\"@label\":\"InvalidLoginAttempts\",\"#text\":\"0\"},\"passwordencryption\":{\"@label\":\"PasswordEncryption\",\"@display\":\"SHA-512\",\"#text\":\"2\"},\"authtype\":{\"@label\":\"AuthType\",\"@display\":\"Standard\",\"#text\":\"0\"},\"userchangeauth\":{\"@label\":\"UserChangeAuth\",\"@display\":\"All users\",\"#text\":\"0\"},\"langno\":{\"@label\":\"LangNo\",\"@link\":\"https://welc-uat.callidusondemand.com/PM/REST/entity/lang/pk/14855288935600000\",\"@display\":\"English\",\"#text\":\"14855288935600000\"},\"fstuser\":{\"@label\":\"FstUser\",\"#text\":\"JSTONE\"},\"fstdate\":{\"@label\":\"FstDate\",\"@display\":\"05/02/2017\",\"#text\":\"20170502\"},\"lstuser\":{\"@label\":\"LstUser\",\"#text\":\"DHARDIN\"},\"lstdate\":{\"@label\":\"LstDate\",\"@display\":\"05/15/2019\",\"#text\":\"20190515\"},\"versno\":{\"@label\":\"VersNo\",\"#text\":\"16\"}}]}";

        ReadContext context = JsonPath.parse(json);

        for (String key : keysToExtract) {
            JSONArray read = context.read("$.content[*]." + key.toLowerCase() + ".#text");
            System.out.println(read.get(0));
        }
    }
}
