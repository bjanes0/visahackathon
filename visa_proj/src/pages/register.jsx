import React, { Component } from 'react';
import { Form, Button, Container, Row, Col, InputGroup } from 'react-bootstrap';
import '../css/register.css';
import { Formik } from 'formik';
import * as yup from 'yup'


const schema = yup.object({
    firstName: yup.string().required(),
    lastName: yup.string().required(),
    email: yup.string().required(),
    dob: yup.string().required(),
    phone: yup.string().required(),
    password: yup.string().required(),
    confirmPassword: yup.string().required()
});

export const Register = () => (
    <React.Fragment>
        <Container fluid>
            <Row>
                <Col></Col>
                <Col id="col_register">
                    <br />
                    <br />
                    <br />
                    <br />
                    <Formik
                        validationSchema={schema}
                        onSubmit={console.log}
                        initialValues={{
                            firstName: '',
                            lastName: '',
                        }}
                    >
                        {({
                            handleSubmit,
                            handleChange,
                            handleBlur,
                            values,
                            touched,
                            isValid,
                            errors,
                        }) => (
                                <Form noValidate onSubmit={handleSubmit}>
                                    <Form.Row>
                                        <Form.Group as={Col} md="6" controlId="validationFormik01">
                                            <Form.Label>First name</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="First name"
                                                name="firstName"
                                                value={values.firstName}
                                                onChange={handleChange}
                                                isValid={touched.firstName && !errors.firstName}
                                            />
                                            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                                        </Form.Group>
                                        <Form.Group as={Col} md="6" controlId="validationFormik02">
                                            <Form.Label>Last name</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Last name"
                                                name="lastName"
                                                value={values.lastName}
                                                onChange={handleChange}
                                                isValid={touched.lastName && !errors.lastName}
                                            />
                                            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Form.Row>
                                        <Form.Group as={Col} md="12" controlId="validationFormik03">
                                            <Form.Label>Email</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Email"
                                                name="city"
                                                value={values.city}
                                                onChange={handleChange}
                                                isInvalid={!!errors.city}
                                            />
                                            <Form.Control.Feedback type="invalid">
                                                {errors.email}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Form.Row>
                                        <Form.Group as={Col} md="6" controlId="validationFormik04">
                                            <Form.Label>Date of Birth</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Date of Birth"
                                                name="dob"
                                                value={values.dob}
                                                onChange={handleChange}
                                                isInvalid={!!errors.dob}
                                            />
                                            <Form.Control.Feedback type="invalid">
                                                {errors.dob}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                        <Form.Group as={Col} md="6" controlId="validationFormik05">
                                            <Form.Label>Phone #</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Phone #"
                                                name="phone"
                                                value={values.phone}
                                                onChange={handleChange}
                                                isInvalid={!!errors.phone}
                                            />

                                            <Form.Control.Feedback type="invalid">
                                                {errors.phone}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Form.Row>
                                        <Form.Group as={Col} md="6" controlId="validationFormik06">
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Password"
                                                name="password"
                                                value={values.password}
                                                onChange={handleChange}
                                                isInvalid={!!errors.password}
                                            />

                                            <Form.Control.Feedback type="invalid">
                                                {errors.password}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                        <Form.Group as={Col} md="6" controlId="validationFormik07">
                                            <Form.Label>Confirm Password</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Confirm Password"
                                                name="confirm password"
                                                value={values.confirmPassword}
                                                onChange={handleChange}
                                                isInvalid={!!errors.confirmPassword}
                                            />
                                            <Form.Control.Feedback type="invalid">
                                                {errors.confirmPassword}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Button variant="secondary" type="submit">Create Account</Button>
                                </Form>
                            )}
                    </Formik>
                </Col>
                <Col></Col>
            </Row>
        </Container>
    </React.Fragment>
)