/*
2. Дана строка sql-запроса "select * from students where ". 
Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json строки. Если значение null, 
то параметр не должен попадать в запрос. Параметры для фильтрации: 
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Ответ: "select * from students where name = 'Ivanov' and country = 'Russia' and city = 'Moscow'"
*/
public class task02 {
    public static void main(String[] args) {
        String str = new String("select * from students where ");
        String strJson = new String("{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}");
        String newStr = "";
        int count;
        StringBuilder sb = new StringBuilder(strJson);
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.substring(i, i+1).equals("{") || sb.substring(i, i+1).equals("'") || sb.substring(i, i+1).equals("}") ) {
                sb.deleteCharAt(i);
            } 
        }
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
               
        for (int i = 0; i < sb.length(); i++) {
            if (sb.substring(i, i+4).equals("null")) {
                count = i+3;
                while (!sb.substring(count-1, count).equals(",")) {
                    sb.deleteCharAt(count);
                    count -=1;
                }
                sb.deleteCharAt(count-1);
                sb.deleteCharAt(count-1);
                break;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.substring(i, i+1).equals(":")) {
                sb.replace(i, i+1, "=");
                sb.insert(i, " ");
                sb.insert(i+2, " '");
            }
            if (sb.substring(i, i+1).equals(",")) {
                sb.replace(i, i+1, "' and");
            }
        }
        sb.append("'");

        System.out.println(str + sb);

    }
}

