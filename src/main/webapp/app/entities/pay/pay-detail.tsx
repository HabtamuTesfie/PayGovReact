import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './pay.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const PayDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const payEntity = useAppSelector(state => state.pay.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="payDetailsHeading">Pay</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{payEntity.id}</dd>
          <dt>
            <span id="cik">Cik</span>
          </dt>
          <dd>{payEntity.cik}</dd>
          <dt>
            <span id="ccc">Ccc</span>
          </dt>
          <dd>{payEntity.ccc}</dd>
          <dt>
            <span id="paymentAmount">Payment Amount</span>
          </dt>
          <dd>{payEntity.paymentAmount}</dd>
          <dt>
            <span id="name">Name</span>
          </dt>
          <dd>{payEntity.name}</dd>
          <dt>
            <span id="email">Email</span>
          </dt>
          <dd>{payEntity.email}</dd>
          <dt>
            <span id="phone">Phone</span>
          </dt>
          <dd>{payEntity.phone}</dd>
          <dt>
            <span id="approval">Approval</span>
          </dt>
          <dd>{payEntity.approval}</dd>
        </dl>
        <Button tag={Link} to="/pay" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/pay/${payEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default PayDetail;
