package com.example.check;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2023/11/11 16:48
 * 4
 */
public class CheckUtils {

    private static final String PRE_ERROR_INFO = "参数:";

    private static final String CAN_NOT_EMPTY = "，不能为空！";

    private static final String LENGTH_CHECK_FALSE = "，不符合长度要求！";

    private static final String NEED_STRING = "，不符合类型要求，应为字符串类型！";

    private static final String NEED_NUMBER = "，不符合类型要求，应为数字类型！";

    private static final String NEED_LIST = "，不符合类型要求，应为List类型！";

    private static final String NEED_MAP = "，不符合类型要求，应为Map类型！";



    public static void main(String[] args) throws Exception {

        List list = new ArrayList();
        String[] strings = {CheckPatternEnum.NUM_02.getPattern()};
        CheckParamsDto checkParamsDto = new CheckParamsDto("ok", "Number", 1211.44, "0", "5,2", strings);
        list.add(checkParamsDto);
        checkEachparams(list);
    }

    /**
     * name             String      必输(基础值)      ps:字段名
     * value            Object      必输(基础值)      ps:字段值
     * type             String      必输(校验项)      ps:字段类型：String，Number,List,Map
     * needNotEmpty     String      非必输(校验项)    ps:1：非空，0：可以为空
     * length           String      非必输(校验项)    ps:Type为Number时支持小数点，如：12代表只校验整数位的长度，12,2代表校验整数和小数位的长度
     * specialType      String[]    非必输(校验项)    ps:例：new String[]{CheckPatternEnum.NUM_02.getPattern()}
     * <p>
     * ps01: 共包含四种校验，类型，非空，长度，特殊正则。后三种非必传，不传时默认为不校验
     * ps02: specialType只有Type为String时可以传，Number暂不支持特殊校验，如果需要可以联系我
     * ps03: List和Map只能校验其本身的属性，不支持遍历
     *
     * @param params
     * @throws Exception
     */
    public static void checkEachparams(List<CheckParamsDto> params) throws Exception {
        String throwStr = "";
        String throwName = "";
        try {
            for (CheckParamsDto checkParamsDto : params) {
                throwName = checkParamsDto.getName();
                String type = checkParamsDto.getType();
                if ("String".equals(type)) {
                    throwStr = checkString(checkParamsDto);
                } else if ("Number".equals(type)) {
                    throwStr = checkNumber(checkParamsDto);
                } else if ("List".equals(type)) {
                    throwStr = checkList(checkParamsDto);
                } else if ("Map".equals(type)) {
                    throwStr = checkMap(checkParamsDto);
                }

                if (throwStr != null && !"".equals(throwStr)) {
                    throw new Exception(throwStr);
                }

            }
        }
//        catch (MyException e) {
//            //TODO 校验参数时异常
//            e.printStackTrace();
//            throw new Exception("校验参数:" + throwName + "时出现异常");
//        }
        catch (Exception e) {
            //TODO 校验参数时异常
            e.printStackTrace();
            throw new Exception("校验参数:" + throwName + "时出现异常");
        }
    }

    private static String checkString(CheckParamsDto checkParamsDto) {
        String name = checkParamsDto.getName();
        String needNotEmpty = checkParamsDto.getNeedNotEmpty();
        String length = checkParamsDto.getLength();
        String[] specialType = checkParamsDto.getSpecialType();

        //非空校验
        if (checkParamsDto.getValue() == null || "".equals(checkParamsDto.getValue())) {
            if ("1".equals(needNotEmpty)) return PRE_ERROR_INFO + name + CAN_NOT_EMPTY;
        } else {
            //类型校验
            Class<?> valueClass = checkParamsDto.getValue().getClass();
            if (!String.class.isAssignableFrom(valueClass)) {
                return PRE_ERROR_INFO + name + NEED_STRING;
            }

            //确认完类型之后再强转
            String value = (String) (checkParamsDto.getValue());
            //长度校验
            if (length != null && !"".equals(length.trim())) {
                if (value.length() > Integer.parseInt(length)) {
                    return PRE_ERROR_INFO + name + LENGTH_CHECK_FALSE;
                }
            }
            //正则特殊校验
            if (specialType != null) {
                return checkStringPattern(name, value, specialType);
            }
        }


        return null;
    }


    private static String checkNumber(CheckParamsDto checkParamsDto) {
        String name = checkParamsDto.getName();
        String needNotEmpty = checkParamsDto.getNeedNotEmpty();
        ;
        String length = checkParamsDto.getLength();
        String[] specialType = checkParamsDto.getSpecialType();

        //非空校验
        if (checkParamsDto.getValue() == null) {
            if ("1".equals(needNotEmpty)) return PRE_ERROR_INFO + name + CAN_NOT_EMPTY;
        } else {
            //类型校验
            Class<?> valueClass = checkParamsDto.getValue().getClass();
            if (!Number.class.isAssignableFrom(valueClass)) {
                return PRE_ERROR_INFO + name + NEED_NUMBER;
            }

            //确认完类型之后再强转
            String value = String.valueOf(checkParamsDto.getValue());
            //长度校验
            if (length != null && !"".equals(length.trim())) {
                String[] splitedLength = length.split(",");
                int preLength = Integer.parseInt(splitedLength[0]);

                String[] splitedString = value.split("\\.");
                String preVal = splitedString[0];
                if (preVal.length() > preLength) {
                    return PRE_ERROR_INFO + name + LENGTH_CHECK_FALSE;
                }

                //判断是否有小数点校验
                if (splitedLength.length == 2) {
                    int postLength = Integer.parseInt(splitedLength[1]);
                    if (new BigDecimal(value).scale() > postLength) {
                        return PRE_ERROR_INFO + name + LENGTH_CHECK_FALSE;
                    }
                }
            }
            //正则校验
//            return checkNumberPattern(name, value, specialType);
        }
        return null;
    }

    private static String checkStringPattern(String name, String value, String[] specialType) {
        for (String pattern : specialType) {
            if (CheckPatternEnum.NUM_01.getPattern().equals(pattern)) {
                if (!Pattern.matches(CheckPatternEnum.NUM_01.getPattern(), value)) {
                    return PRE_ERROR_INFO + name + CheckPatternEnum.NUM_01.getErrorInfo();
                }
            }
            if (CheckPatternEnum.NUM_ENG.getPattern().equals(pattern)) {
                if (!Pattern.matches(CheckPatternEnum.NUM_ENG.getPattern(), value)) {
                    return PRE_ERROR_INFO + name + CheckPatternEnum.NUM_ENG.getErrorInfo();
                }
            }
            if (CheckPatternEnum.CHN_ENG_NUM.getPattern().equals(pattern)) {
                if (!Pattern.matches(CheckPatternEnum.CHN_ENG_NUM.getPattern(), value)) {
                    return PRE_ERROR_INFO + name + CheckPatternEnum.CHN_ENG_NUM.getErrorInfo();
                }
            }
            if (CheckPatternEnum.ID_CARD.getPattern().equals(pattern)) {
                if (!Pattern.matches(CheckPatternEnum.ID_CARD.getPattern(), value)) {
                    return PRE_ERROR_INFO + name + CheckPatternEnum.ID_CARD.getErrorInfo();
                }
            }
            if (CheckPatternEnum.EMAIL.getPattern().equals(pattern)) {
                if (!Pattern.matches(CheckPatternEnum.EMAIL.getPattern(), value)) {
                    return PRE_ERROR_INFO + name + CheckPatternEnum.EMAIL.getErrorInfo();
                }
            }
            if (CheckPatternEnum.PHONE.getPattern().equals(pattern)) {
                if (!Pattern.matches(CheckPatternEnum.PHONE.getPattern(), value)) {
                    return PRE_ERROR_INFO + name + CheckPatternEnum.PHONE.getErrorInfo();
                }
            }
            if (CheckPatternEnum.NUM_02.getPattern().equals(pattern)) {
                if (!Pattern.matches(CheckPatternEnum.NUM_02.getPattern(), value)) {
                    return PRE_ERROR_INFO + name + CheckPatternEnum.NUM_02.getErrorInfo();
                }
            }
        }
        return null;
    }

//    private static String checkNumberPattern(String name, String value, String[] specialType) {
//        for (String pattern : specialType) {
//            if (CheckPatternEnum.EMAIL.getPattern().equals(pattern)) {
//                if (!Pattern.matches(CheckPatternEnum.EMAIL.getPattern(), value)) {
//                    return PRE_ERROR_INFO + name + CheckPatternEnum.EMAIL.getErrorInfo();
//                }
//            }
//            if (CheckPatternEnum.NUM_02.getPattern().equals(pattern)) {
//                if (!Pattern.matches(CheckPatternEnum.NUM_02.getPattern(), value)) {
//                    return PRE_ERROR_INFO + name + CheckPatternEnum.NUM_02.getErrorInfo();
//                }
//            }
//        }
//        return null;
//    }


    private static String checkList(CheckParamsDto checkParamsDto) {
        String name = checkParamsDto.getName();
        String needNotEmpty = checkParamsDto.getNeedNotEmpty();
        ;
        String length = checkParamsDto.getLength();

        //非空校验
        if (checkParamsDto.getValue() == null) {
            if ("1".equals(needNotEmpty)) return PRE_ERROR_INFO + name + CAN_NOT_EMPTY;
        } else {
            //类型校验
            Class<?> valueClass = checkParamsDto.getValue().getClass();
            if (!List.class.isAssignableFrom(valueClass)) {
                return PRE_ERROR_INFO + name + NEED_LIST;
            }

            //确认完类型之后再强转
            List list = (List) checkParamsDto.getValue();
            //非空校验
            if (list.isEmpty()) {
                if ("1".equals(needNotEmpty)) return PRE_ERROR_INFO + name + CAN_NOT_EMPTY;
            }

            //长度校验
            if (length != null && !"".equals(length.trim())) {
                int maxLength = Integer.parseInt(length);
                if (list.size() > maxLength) {
                    return PRE_ERROR_INFO + name + LENGTH_CHECK_FALSE;
                }
            }
            //特殊校验
        }


        return null;
    }

    private static String checkMap(CheckParamsDto checkParamsDto) {
        String name = checkParamsDto.getName();
        String needNotEmpty = checkParamsDto.getNeedNotEmpty();
        String length = checkParamsDto.getLength();

        //非空校验
        if (checkParamsDto.getValue() == null) {
            if ("1".equals(needNotEmpty)) return PRE_ERROR_INFO + name + CAN_NOT_EMPTY;
        } else {
            //类型校验
            Class<?> valueClass = checkParamsDto.getValue().getClass();
            if (!Map.class.isAssignableFrom(valueClass)) {
                return PRE_ERROR_INFO + name + NEED_MAP;
            }

            //确认完类型之后再强转
            Map map1 = (Map) checkParamsDto.getValue();
            //非空校验
            if (map1.isEmpty()) {
                if ("1".equals(needNotEmpty)) return PRE_ERROR_INFO + name + CAN_NOT_EMPTY;
            }

            //长度校验
            if (length != null && !"".equals(length.trim())) {
                int maxLength = Integer.parseInt(length);
                if (map1.size() > maxLength) {
                    return PRE_ERROR_INFO + name + LENGTH_CHECK_FALSE;
                }
            }

            //特殊校验
        }

        return null;
    }
}
