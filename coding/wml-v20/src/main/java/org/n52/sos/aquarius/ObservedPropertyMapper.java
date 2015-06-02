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

public class ObservedPropertyMapper {

    private static final Map<String, String> OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP;

    static {
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP = new HashMap<>();
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Discharge_DayMean", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Discharge_HourMean", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Discharge", InterpolationTypeMapper.INSTANTANEOUS);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Duration_RainDayMonth", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Duration_RainDayYear", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_DayTotal", InterpolationTypeMapper.TOTAL_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_HourTotal", InterpolationTypeMapper.TOTAL_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_MonthMaximum", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_MonthMean", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_MonthMedian", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_MonthMinimum", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_MonthTotal", InterpolationTypeMapper.TOTAL_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Precip Total_YearTotal", InterpolationTypeMapper.TOTAL_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Stage_DayMean", InterpolationTypeMapper.INSTANTANEOUS);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Stage_MonthMaximum", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Stage_MonthMedian", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Stage_MonthMinimum", InterpolationTypeMapper.AVERAGE_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.put("Take Volume_TotalMeteredUse", InterpolationTypeMapper.TOTAL_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP
                .put("Water Use Allocation_TotalConsented", InterpolationTypeMapper.TOTAL_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP
                .put("Water Use Allocation_TotalMetered", InterpolationTypeMapper.TOTAL_PREC);
        OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP
                .put("Water Use Allocation_TotalMeteredUse", InterpolationTypeMapper.TOTAL_PREC);
    }

    public String toInterpolationTypeName(String observedPropertyName) {
        if (null == observedPropertyName) {
            return null;
        } else {
            return OBSERVED_PROPERTY_INTERPOLATION_TYPE_MAP.get(observedPropertyName);
        }
    }
}
