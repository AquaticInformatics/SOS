/**
 * Copyright (C) 2012-2015 Aquatic Informatics
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.sos.aquarius;

import java.util.HashMap;
import java.util.Map;

public class InterpolationTypeMapper {

    static final String INSTANTANEOUS = "Instantaneous";
    static final String DISCRETE = "Discrete";
    static final String AVERAGE_PREC = "AveragePrec";
    static final String AVERAGE_SUCC = "AverageSucc";
    static final String INSTANT_TOTAL = "InstantTotal";
    static final String TOTAL_PREC = "TotalPrec";

    private static final Map<String, String> WML2_INTERPOLATION_TYPE_HREF_MAP;
    private static final Map<String, String> WML2_INTERPOLATION_TYPE_TITLE_MAP;

    static {
        WML2_INTERPOLATION_TYPE_HREF_MAP = new HashMap<>();
        WML2_INTERPOLATION_TYPE_HREF_MAP.put(INSTANTANEOUS,
                "http://www.opengis.net/def/waterml/2.0/interpolationType/Continuous");
        WML2_INTERPOLATION_TYPE_HREF_MAP.put(DISCRETE,
                "http://www.opengis.net/def/waterml/2.0/interpolationType/Discontinuous");
        WML2_INTERPOLATION_TYPE_HREF_MAP.put(AVERAGE_PREC,
                "http://www.opengis.net/def/waterml/2.0/interpolationType/AveragePrec");
        WML2_INTERPOLATION_TYPE_HREF_MAP.put(AVERAGE_SUCC,
                "http://www.opengis.net/def/waterml/2.0/interpolationType/AverageSucc");
        WML2_INTERPOLATION_TYPE_HREF_MAP.put(INSTANT_TOTAL,
                "http://www.opengis.net/def/waterml/2.0/interpolationType/InstantTotal");
        WML2_INTERPOLATION_TYPE_HREF_MAP.put(TOTAL_PREC,
                "http://www.opengis.net/def/waterml/2.0/interpolationType/TotalPrec");

        WML2_INTERPOLATION_TYPE_TITLE_MAP = new HashMap<>();
        WML2_INTERPOLATION_TYPE_TITLE_MAP.put(INSTANTANEOUS, "Continuous");
        WML2_INTERPOLATION_TYPE_TITLE_MAP.put(DISCRETE, "Discontinuous");
        WML2_INTERPOLATION_TYPE_TITLE_MAP.put(AVERAGE_PREC, AVERAGE_PREC);
        WML2_INTERPOLATION_TYPE_TITLE_MAP.put(AVERAGE_SUCC, AVERAGE_SUCC);
        WML2_INTERPOLATION_TYPE_TITLE_MAP.put(INSTANT_TOTAL, INSTANT_TOTAL);
        WML2_INTERPOLATION_TYPE_TITLE_MAP.put(TOTAL_PREC, TOTAL_PREC);
    }

    public String toHref(String aquariusInterpolationType) {
        if (null == aquariusInterpolationType) {
            return null;
        } else {
            return WML2_INTERPOLATION_TYPE_HREF_MAP.get(aquariusInterpolationType);
        }
    }

    public String toTitle(String aquariusInterpolationType) {
        if (null == aquariusInterpolationType) {
            return null;
        } else {
            return WML2_INTERPOLATION_TYPE_TITLE_MAP.get(aquariusInterpolationType);
        }
    }

}
