import React, { useState } from 'react';

const Grid = () => {
  const [propertyData, setPropertyData] = useState({
    address: '',
    city: '',
    pincode: '',
    contactDetails: '',
    flatType: '',
    propertyPrice: '',
    propertyArea: ''
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setPropertyData(prevData => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // You can handle form submission here, e.g., sending data to a server
    console.log(propertyData);
  };

  return (
    <div>
      <h1>Property List Page</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Address:</label>
          <input type="text" name="address" value={propertyData.address} onChange={handleInputChange} />
        </div>
        <div>
          <label>City:</label>
          <input type="text" name="city" value={propertyData.city} onChange={handleInputChange} />
        </div>
        <div>
          <label>Pincode:</label>
          <input type="text" name="pincode" value={propertyData.pincode} onChange={handleInputChange} />
        </div>
        <div>
          <label>Contact Details:</label>
          <input type="text" name="contactDetails" value={propertyData.contactDetails} onChange={handleInputChange} />
        </div>
        <div>
          <label>Flat Type:</label>
          <select name="flatType" value={propertyData.flatType} onChange={handleInputChange}>
            <option value="">Select</option>
            <option value="1rk">1RK</option>
            <option value="1bhk">1BHK</option>
            <option value="2bhk">2BHK</option>
            <option value="3bhk">3BHK</option>
          </select>
        </div>
        <div>
          <label>Property Price:</label>
          <input type="text" name="propertyPrice" value={propertyData.propertyPrice} onChange={handleInputChange} />
        </div>
        <div>
          <label>Property Area:</label>
          <input type="text" name="propertyArea" value={propertyData.propertyArea} onChange={handleInputChange} />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default Grid;
