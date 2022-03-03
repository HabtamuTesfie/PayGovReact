import React, { useState, useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity, updateEntity, createEntity, reset } from './pay.reducer';
import { IPay } from 'app/shared/model/pay.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const PayUpdate = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  const [isNew] = useState(!props.match.params || !props.match.params.id);

  const payEntity = useAppSelector(state => state.pay.entity);
  const loading = useAppSelector(state => state.pay.loading);
  const updating = useAppSelector(state => state.pay.updating);
  const updateSuccess = useAppSelector(state => state.pay.updateSuccess);
  const handleClose = () => {
    props.history.push('/pay');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(props.match.params.id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...payEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          ...payEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="reactProjectApp.pay.home.createOrEditLabel" data-cy="PayCreateUpdateHeading">
            Create or edit a Pay
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? <ValidatedField name="id" required readOnly id="pay-id" label="ID" validate={{ required: true }} /> : null}
              <ValidatedField label="Cik" id="pay-cik" name="cik" data-cy="cik" type="text" />
              <ValidatedField label="Ccc" id="pay-ccc" name="ccc" data-cy="ccc" type="text" />
              <ValidatedField label="Payment Amount" id="pay-paymentAmount" name="paymentAmount" data-cy="paymentAmount" type="text" />
              <ValidatedField label="Name" id="pay-name" name="name" data-cy="name" type="text" />
              <ValidatedField label="Email" id="pay-email" name="email" data-cy="email" type="text" />
              <ValidatedField label="Phone" id="pay-phone" name="phone" data-cy="phone" type="text" />
              <ValidatedField label="Approval" id="pay-approval" name="approval" data-cy="approval" type="text" />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/pay" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">Back</span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp; Save
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default PayUpdate;
