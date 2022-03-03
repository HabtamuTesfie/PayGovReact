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
import './ProductInfo.scss';

class ProductInfo extends React.Component<any, any> {
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

 // async
  componentDidMount() {
    try {
     // setInterval(async () => {
        axios.get('/api/productInfo').then(
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
     // }, 1000);
    } catch (e) {
      console.log(e);
    }
  }

  sessionExpires = () => {
    // this.setState({showModal: false});
    this.props.history.push('/paymentSave');
  };

  savePaymentToDatabase = item => {
    sessionStorage.setItem('product', JSON.stringify(item));
  };

  getColor = approval => {
    if (approval === 'Rejected') return 'red';
    if (approval === 'Accepted') return 'green';
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
            <td>{item.productName}</td>
            <td>{item.productPrice}</td>
            <td>{item.expireDate}</td>
            <td> <Button type="submit" color="primary" id="nxt" tag={Link} to="/paygovr" >
                           <span>buy </span>
                 </Button></td>
          </tr>
        );
      });

      return (
        <>
          <div className="container">
            <div className="row">
              <div className="col-md-6 col-md-offset-5">

                <table>
                  <tr>
                    <th>Product Name</th>
                    <th>Product Price</th>
                    <th>Expiration Date</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Buy Product</th>
                  </tr>
                  {contents}
                </table>
                <Button type="submit" color="primary" id="nxt" tag={Link} to="/Activemq" >
                           <span>&nbsp;Back&nbsp;&nbsp;</span>
                 </Button>

              </div>
            </div>
            <Modal show={this.state.showModal}>
              <Modal.Header closeButton>
                <Modal.Title>Confirmation Message</Modal.Title>
              </Modal.Header>
              <Modal.Body>
                <form>
                  <label>
                    Account Number:
                    <input type="number" name="name" />
                  </label>
                  <br />
                </form>
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
export default ProductInfo;
