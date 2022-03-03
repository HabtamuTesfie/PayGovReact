/* eslint-disable no-labels */
/* eslint-disable prefer-const */
/* eslint-disable no-console */
/* eslint-disable @typescript-eslint/require-await */
/* eslint-disable react/jsx-key */
import React, { useState, useEffect, useRef } from 'react';
import { Link, Redirect, Route, RouteComponentProps } from 'react-router-dom';
import { Row, Col, Alert, Button } from 'reactstrap';
import { useAppSelector, useAppDispatch } from 'app/config/store';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { getEntity, updateEntity, createEntity, reset } from 'app/entities/pay/pay.reducer';
import { Component } from 'react';
import { connect } from 'react-redux';
import type { FormEvent } from 'react';
import IdleTimer from 'react-idle-timer';
import { Translate } from 'react-jhipster';
import sinon from 'sinon';
import axios from 'axios';
import { Modal } from 'react-bootstrap';
import './activemq.scss';

class Activemq extends React.Component<any, any> {
  data1: any;
  x: string;
  value: any;
  index: 0;
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      data: [],
      showModal: false,
      index: 0,
    };
  }

  async componentDidMount() {
    try {
      setInterval(async () => {
        axios.get('/api/customers').then(
          res => {
            this.data1 = res.data;
            this.setState({
              isLoaded: true,
              data: res.data,
            });
          },
          error => {
            this.setState({
              isLoaded: true,
              error,
            });
          }
        );
      }, 1000);
    } catch (e) {
      console.log(e);
    }
  }

  sessionExpires = () => {
     this.setState({showModal: false});
    // this.props.history.push('/ProductInfo');
  };

  savePaymentToDatabase = item => {
     axios.post(`/api/payment`, {
    cik:item.cik,
    ccc:item.ccc,
    paymentAmount:item.paymentAmount,
    name:item.name,
    email:item.email,
    phone:item.phone,
  approval:item.approval })
  .then(res => {
     axios.delete(`/api/customers/${item.ccc}`).then(response=>{

    this.setState({ showModal: true });
     })

    console.log(item.cik, item.ccc, item.paymentAmount, item.name, item.email, item.phone);
     })
  };

  getColor = approval => {
    if (approval === 'rejected') return 'red';
    if (approval === 'accepted') return 'green';
    return '';
  };

  getNotProcessedValue = approval => {
    if (approval == null) return 'NOT PROCESSED!';

    return '';
  };

  render() {
    const { error, isLoaded, data, index } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
      return <div>Loading...</div>;
    } else {
      const contents = this.state.data?.map(item => {
        // change the title and location key based on your API
        return (
          <tr onClick={() => this.savePaymentToDatabase(item)}>
            <td>{item.cik}</td>
            <td>{item.ccc}</td>
            <td>{item.paymentAmount}</td>
            <td>{item.name}</td>
            <td>{item.email}</td>
            <td>{item.phone}</td>
            <td style={{ color: this.getColor(item.approval) }}>
              {item.approval} {this.getNotProcessedValue(item.approval)}
            </td>
            <td>
              {' '}
              &nbsp;
              <Button replace color="primary">
                <span className="d-none d-md-inline">Save</span>
              </Button>
            </td>
          </tr>
        );
      });

      return (
        <>
          <div className="container">
            <div className="row">
              <div className="col-md-6 col-md-offset-5">
                <h1 className="title">All payments</h1>
                <table>
                  <tr>
                    <th>Cik</th>
                    <th>CCC</th>
                    <th>PaymentAmount</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Aprovement</th>
                    <th>Pay</th>
                  </tr>
                  {contents}
                </table>
              </div>
            </div>
            <Modal show={this.state.showModal}>
              <Modal.Header closeButton>
                <Modal.Title>Confirmation Message</Modal.Title>
              </Modal.Header>
              <Modal.Body>
               Successfully saved!
              </Modal.Body>
              <Modal.Footer>
                <Button variant="primary" onClick={this.sessionExpires}>
                  Send
                </Button>
              </Modal.Footer>
            </Modal>
          </div>
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
        </>
      );
    }
  }
}
export default Activemq;
