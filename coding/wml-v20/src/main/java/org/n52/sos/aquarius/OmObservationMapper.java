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

import org.n52.sos.ogc.om.OmObservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OmObservationMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(OmObservationMapper.class);
    private static final String DEFAULT_AQUARIUS_INTERPOLATION_TYPE = InterpolationTypeMapper.INSTANTANEOUS;
    private static final String BASE_LOGGER_INTERPOLATION_MAPPING_WARNING =
            "Could not determine aquarius interpolation type";
    private final InterpolationTypeMapper interpolationTypeMapper;
    private final ObservedPropertyMapper observedPropertyMapper;

    public OmObservationMapper(
            InterpolationTypeMapper interpolationTypeMapper,
            ObservedPropertyMapper observedPropertyMapper) {
        this.interpolationTypeMapper = interpolationTypeMapper;
        this.observedPropertyMapper = observedPropertyMapper;
    }

    public String toInterpolationTypeTitle(OmObservation observation) {
        String wml2InterpolationTitle = interpolationTypeMapper.toTitle(DEFAULT_AQUARIUS_INTERPOLATION_TYPE);

        final String observedPropertyIdentifier = getObservedPropertyIdentifier(observation);

        final String title = interpolationTypeMapper.toTitle(
                observedPropertyMapper.toInterpolationTypeName(observedPropertyIdentifier));

        if (null != title) {
            wml2InterpolationTitle = title;
        } else {
            LOGGER.info(BASE_LOGGER_INTERPOLATION_MAPPING_WARNING +
                    ": invalid identifier {}", observedPropertyIdentifier);
        }

        return wml2InterpolationTitle;
    }

    public String toInterpolationTypeHref(final OmObservation observation) {
        String wml2InterpolationHref = interpolationTypeMapper.toHref(DEFAULT_AQUARIUS_INTERPOLATION_TYPE);

        final String observedPropertyIdentifier = getObservedPropertyIdentifier(observation);

        final String href = interpolationTypeMapper.toHref(
                observedPropertyMapper.toInterpolationTypeName(observedPropertyIdentifier));

        if (null != href) {
            wml2InterpolationHref = href;
        } else {
            LOGGER.info(BASE_LOGGER_INTERPOLATION_MAPPING_WARNING +
                    ": invalid identifier {}", observedPropertyIdentifier);
        }
        return wml2InterpolationHref;
    }

    private String getObservedPropertyIdentifier(OmObservation observation) {

        if (null != observation && null != observation.getObservationConstellation() &&
                null != observation.getObservationConstellation().getObservableProperty()) {

            return observation.getObservationConstellation().getObservableProperty().getIdentifier();
        } else {
            LOGGER.info(BASE_LOGGER_INTERPOLATION_MAPPING_WARNING + ": invalid observation");
            return null;
        }
    }

}
